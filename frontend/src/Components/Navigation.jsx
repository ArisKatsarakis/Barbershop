import {Nav} from "react-bootstrap";

export const Navigation = () => {
    const handleSelect = (eventKey) =>  {
        console.log(eventKey);
        document.getElementById('navigate-bar').setAttribute('activeKey', `${eventKey}`);
    }
    return (
        <>
            <Nav  id={'navigate-bar'} justify variant="underline" onSelect={handleSelect}>
                <Nav.Item>
                    <Nav.Link eventKey="1" href="/dashboard">
                        Dashboard
                    </Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link eventKey="2" title="Item" href='/customers'>
                        Customers
                    </Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link eventKey="3" href='/products'>
                        Products
                    </Nav.Link>
                </Nav.Item>
                <Nav.Item>
                    <Nav.Link eventKey="4" href='/orders'>
                        Orders
                    </Nav.Link>
                </Nav.Item>
            </Nav>
        </>
    )
}