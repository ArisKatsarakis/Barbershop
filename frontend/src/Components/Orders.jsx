import {Component} from 'react'
import {Navigation} from "./Navigation";
import {Table} from "react-bootstrap";

export class Orders extends Component {

    constructor(props) {
        super(props);
        this.state = {
            orders: []
        }
    }
    async componentDidMount() {

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
                            <th>Products</th>
                        </tr>
                    </thead>
                    <tbod>

                    </tbod>
                </Table>
            </>
        )
    }
}