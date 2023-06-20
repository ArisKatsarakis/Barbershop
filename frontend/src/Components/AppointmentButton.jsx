import {Button, Form, Modal} from "react-bootstrap";
import {useState, useEffect} from "react";
import {DateTime} from "luxon";

export const AppointmentButton = (props) => {
    const [show, setShow] = useState(false);
    const [timeslot,setTimeslot] = useState(0)
    const handleShow =  () => { setShow(true) };
    const handleClose = () => { setShow(false) };
    const generateTimeSlots = () => {
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
    const timeSlots = generateTimeSlots();
    console.log(timeSlots);
    return (
        <>
        <Button variant={'primary'}  onClick={handleShow}> Book Appointment </Button>
        <Modal show={show}>
            <Modal.Header closeButton >
                Book Appointment for {props.barbersName}
            </Modal.Header>
            <Modal.Body>
                <Form>
                    <Form.Label>Select Time Slot</Form.Label>
                    <Form.Select aria-label="Default select example" value={timeslot} onChange={ event => setTimeslot(event.target.value)}>
                        <option value={0}> Select available Time Slot</option>
                        {
                            timeSlots.map(
                                slot => <option value={slot.time}>{slot.time}</option>
                            )
                        }

                    </Form.Select>
                    
                </Form>
                <Button onClick={handleClose} variant={'danger'}>Close</Button>
            </Modal.Body>
        </Modal>
        </>
    )
}