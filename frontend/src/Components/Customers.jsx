import {Component} from 'react'
import {Navigation} from "./Navigation";
import {Table} from "react-bootstrap";
import axios from "axios";
import {CreateClientButton} from "./CreateClientButton";
export class Customers extends Component {
    constructor(props) {
        super(props);
        this.state = {
            customers: [],
        };

    }

    async componentDidMount() {
        const getCustomers = await this.getCustomersApi();
        this.setState({
            customers: getCustomers.data
        });
    }
    getCustomersApi = () => {
        return axios.get('http://localhost:8080/api/v1/clients');

    }

    render() {
        return (
            <>
                <Navigation />
                <h2>Customer's Data</h2>
                <Table responsive>
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>First Name</th>
                            <th>Last Name</th>
                            <th>Phone</th>
                            <th>Address</th>
                        </tr>
                    </thead>
                    <tbody>
                        {this.state.customers.map(
                            customer =>  <tr>
                                <td>{customer.id}</td>
                                <td>{customer.firstName}</td>
                                <td>{customer.lastName}</td>
                                <td>{customer.phone}</td>
                                <td>{customer.address}</td>
                            </tr>
                            )}
                        <tr >
                            <td colSpan={5} >
                                <CreateClientButton />

                            </td>
                        </tr>
                    </tbody>

                </Table>
            </>
        )
    }
}