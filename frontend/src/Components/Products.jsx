import {Component} from 'react'
import {Navigation} from "./Navigation";
import {Table} from "react-bootstrap";
import axios from "axios";

export class Products extends Component {

    constructor(props) {
        super(props);
        this.state = {
            products: []
        };

    }
    getProducts = () => {
        return axios.get('http://localhost:8080/api/v1/products');
    }

    async componentDidMount() {
        const productsRequest = await this.getProducts();
        this.setState({
            products: productsRequest.data,
        })

    }

    render() {
        return (
            <>
                <Navigation />
                <h2>Products</h2>
                <Table dark bordeed striped>
                    <thead>
                    <tr>
                        <th>Id</th>
                        <th>Product Name</th>
                        <th>Cost</th>
                        <th>Type</th>
                        <th>No. of Orders</th>
                    </tr>
                    </thead>
                    <tbody>
                    {
                        this.state.products.map(
                            product =>
                                <tr>
                                    <th scope={'row'}>{product.id}</th>
                                    <td>{product.name}</td>
                                    <td>{product.cost}</td>
                                    <td>{product.type}</td>
                                    <td>{1}</td>
                                </tr>
                        )
                    }
                    </tbody>

                </Table>

            </>
        )
    }
}