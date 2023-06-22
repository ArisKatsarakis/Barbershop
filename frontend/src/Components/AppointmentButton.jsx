import {Component} from 'react'
import {Button, Form, Modal} from "react-bootstrap";
import {useEffect} from "react";
import {DateTime} from "luxon";
import {CreateClientButton} from "./CreateClientButton";
import axios, {get} from "axios";

export class AppointmentButton extends Component {

     generateTimeSlots = () => {
        const today = DateTime.now();
        const timeSlots = [];
        let begin = DateTime.fromObject({
            year: today.year,
            month: today.month,
            day: today.day,
            hour: 9,
            minutes: 0
        })
        const dayShiftEnd = DateTime.fromObject({
            year: today.year,
            month: today.month,
            day: today.day,
            hour: 14,
            minutes: 0
        })
        console.log(begin.toString());
        console.log(dayShiftEnd.toString());

        while (begin.hour <= dayShiftEnd.hour) {
            const timeSlotsObject = {
                time: begin.toFormat('HH:mm'),
                day: begin.toFormat('yyyy/MM/dd')
            }
            begin =  begin.plus({minutes: 30})
            timeSlots.push(timeSlotsObject);
        }

        return timeSlots;
    }
    constructor(props) {
        super(props);

        this.state = {
            show: false,
            timeslot: 0,
            client: 0,
            timeSlots: [],
            currentClients: [],
        }


    }

    async componentDidMount() {
        const generatedSlots = this.generateTimeSlots();
        this.setState({
            timeSlots: generatedSlots
        })
        const clientsRequest = await this.getClients();
        this.setState({
            currentClients: clientsRequest.data
        })

    }

    handleShow =  () => {
        this.setState({
            show: true
        }) };
    handleClose = () => { this.setState({
        show: false
    }) };

    getClients = async () => {
             return  axios.get('http://localhost:8080/api/v1/clients');
    }
    render() {
        return (
            <>
                <Button variant={'primary'}  onClick={this.handleShow}> Book Appointment </Button>
                <Modal show={this.state.show} onHide={this.handleClose}>
                    <Modal.Header closeButton  >
                        Book Appointment for {this.props.barbersName}
                    </Modal.Header>
                    <Modal.Body>
                        <Form className={'mb-2'}>
                            <Form.Group>
                                <Form.Label htmlFor={'timeSlots'}>Select Time Slot</Form.Label>
                                <Form.Select  id='timeSlots' aria-label="Default select example" value={this.state.timeslot} onChange={ event => this.setState({
                                    timeslot: event.target.value
                                })}>
                                    <option value={0}> Select available Time Slot</option>
                                    {
                                        this.state.timeSlots.map(
                                            slot => <option value={slot.time}>{slot.time}</option>
                                        )
                                    }
                                </Form.Select>
                            </Form.Group>
                            <Form.Group>
                                <Form.Label>Client's Name</Form.Label>
                                <Form.Select className={'mb-2'} aria-label="Default select example" value={this.client} onChange={ event => this.setState({
                                    client: event.target.value
                                })}>
                                    <option value={0}> Choose Client</option>
                                    {this.state.currentClients.map(
                                        client => <option value={client.id}> {client.firstName} {client.lastName} </option>
                                    )}
                                </Form.Select>
                                <CreateClientButton  />
                            </Form.Group>
                            


                        </Form>
                        <Button onClick={this.handleClose} variant={'danger'}>Close</Button>
                    </Modal.Body>
                </Modal>
            </>
        )
    }
}





