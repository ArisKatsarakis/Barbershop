import {Table} from "react-bootstrap";
import {AppointmentButton} from "./AppointmentButton";
import {Component} from "react";
import axios from "axios";
export class RendevouzTable extends Component {
    constructor(props) {
        super(props);
        this.state = {
            ravdevouz : []
        };
        console.log('This is the Barber\'s id : ' +  this.props.barberId);

    }

    async componentDidMount() {
        const barbersAppointment = await this.getAppointmentsByBarberId(this.props.barberId);
        this.setState({
                ravdevouz: barbersAppointment.data,

            }
        )
    }

    getAppointmentsByBarberId = async (barberId) => {
        return axios.get(`http://localhost:8080/api/v1/appointment/${barberId}`);
    }
    render() {
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
                    <tbody>
                    {this.state.ravdevouz.map(
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
                            <AppointmentButton barbersName={this.props.barbersName} barbersId={this.props.barberId}/>
                        </td>
                    </tr>
                    </tbody>
                </Table>
            </>
        )
    }

}