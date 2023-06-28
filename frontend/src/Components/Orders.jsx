import {Component} from 'react'
import {Navigation} from "./Navigation";
import {Table, Button, Modal, ListGroup} from "react-bootstrap";
import axios from 'axios';
import {CreateOrderButton} from "./CreateOrderButton";
export class Orders extends Component {

    constructor(props) {
        super(props);
        this.state = {
            orders: [],
            clients: [],
            show: false,
        }
    }
    async componentDidMount() {
            const getOrders = await this.getOrdersApi();
            this.setState(
                {
                    orders: getOrders.data,
                }
            )
    }
    getOrdersApi = () => {
        return axios.get('http://localhost:8080/api/v1/orders/');
    }

    handleShow = () => {
        this.setState({
            show:true
        })
    }

    handleClose = () => {
        this.setState(
            {
                show: false
            }
        )
    }
    render() {
        return (
            <>
                <Navigation />
                <h2>Orders</h2>
                <Table>
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Client Id</th>
                            <th>Total Cost</th>
                            <th>Actions</th>
                        </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.orders.map(
                            order =>
                                <tr>
                                    <th scope={'row'}>{order.id}</th>
                                    <td>{order.customer_id}</td>
                                    <td>{order.totalCost}</td>
                                    <td>
                                        <Button onClick={this.handleShow}>Show Prodcucts</Button>
                                        <Modal show={this.state.show} onHide={this.handleClose}>
                                            <Modal.Header closeButton>
                                                List of Products
                                            </Modal.Header>
                                            <Modal.Body>
                                                <ListGroup>
                                                    {
                                                        order.products.map(
                                                            product =>
                                                                <ListGroup.Item> Name: {product.name} Cost: {product.cost}</ListGroup.Item>
                                                        )
                                                    }
                                                </ListGroup>
                                            </Modal.Body>
                                        </Modal>
                                    </td>
                            </tr>
                        )
                    }
                    <tr>
                       <td colSpan={4}> <CreateOrderButton /></td>
                    </tr>
                    </tbody>
                </Table>
            </>
        )
    }
}