import {Component} from 'react'
import {Button, Form, Modal} from "react-bootstrap";
import {useEffect} from "react";
import {DateTime} from "luxon";
import {CreateClientButton} from "./CreateClientButton";
import axios, {get} from "axios";

export class AppointmentButton extends Component {
    handleSubmit = async  (event) => {
        event.preventDefault();
        console.log(this.state.client, this.state.timeslot, this.state.hairCutSelected, this.props.barbersId);

        const response = await this.createAppointment( this.state.client, this.state.timeslot, this.state.hairCutSelected, this.props.barbersId);
        window.location.reload(false);
    }
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
            hairCutSelected: 0,
            hairCutTypes: [
                {
                    id: 1,
                    name: 'Mallia',
                    cost: 10
                },
                {
                    id: 1,
                    name: 'Mallia kai mousia',
                    cost: 20
                },
                {
                    id: 1,
                    name: 'Mousia',
                    cost: 10
                }
            ]
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
                            <Form.Group>
                                <Form.Label>Product List</Form.Label>
                                <Form.Select className={'mb-2'} aria-label="Default select example" value={this.hairCutSelected} onChange={ event => this.setState({
                                    hairCutSelected: event.target.value
                                })}>
                                    <option value={0}> Choose Product/Hair Cut</option>
                                    {this.state.hairCutTypes.map(
                                        hairCut => <option value={hairCut.name}> {hairCut.name}  </option>
                                    )}
                                </Form.Select>
                            </Form.Group>
                            <Button onClick={this.handleSubmit}  type={'submit'} variant={'success'}>Create Appointment</Button>
                        </Form>
                        <Button onClick={this.handleClose} variant={'danger'}>Close</Button>
                    </Modal.Body>
                </Modal>
            </>
        )
    }

    createAppointment = async (client, timeslot, hairCutSelected, barbersId) =>  {
        const appointmentDate = DateTime.now();
        const payload = {
            barberId:barbersId,
            customerId: parseInt(client),
            date:appointmentDate.toFormat('yyyy-MM-dd'),
            time:timeslot,
            type: hairCutSelected,
        };
       return   axios.post('http://localhost:8080/api/v1/appointment',payload);

    }
}





