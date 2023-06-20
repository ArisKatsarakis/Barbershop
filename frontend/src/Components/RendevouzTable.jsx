import {Table} from "react-bootstrap";
import {AppointmentButton} from "./AppointmentButton";


export const RendevouzTable = (props) => {
    const ravdevouz = [
        {
            customer: "Aris Katsarakis",
            time: "20:00",
            type: "Mallia",
        },
        {
            customer: "George Katsarakis",
            time: "20:30",
            type: "Mousia",
        }
    ];
    console.log('This is the Barber\'s id : ' +  props.barberId);
    return (
        <>
            <Table striped borderless hover>
                <thead>
                <tr>
                    <th>
                        Time
                    </th>
                    <th>
                        Customer
                    </th>
                    <th>
                        Haircut's Type
                    </th>
                </tr>
                </thead>
                <tr>
                    <th scope={'row'}>

                    </th>
                    <td>
                        Customer's Name
                    </td>
                    <td>
                        Mallia/Mousia
                    </td>
                </tr>
                <tbody>
                {ravdevouz.map(
                    rand =>
                        <tr>
                            <th scope={'row'}>
                                {rand.time}
                            </th>
                            <td>
                                {rand.customer}
                            </td>
                            <td>
                                {rand.type}
                            </td>
                        </tr>
                )}
                <tr>
                    <td colSpan={3}>
                        <AppointmentButton barbersName={props.barbersName} barbersId={props.barberId}/>
                    </td>
                </tr>
                </tbody>
            </Table>
        </>
    )
}