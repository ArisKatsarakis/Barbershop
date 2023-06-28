import {Button, Form, Modal} from "react-bootstrap";
import {useState} from "react";
import axios from "axios";
export const CreateProductButton = () => {
    const [show, setShow] = useState(false);
    const [productName,setProductName] = useState('');
    const [productType,setProductType] = useState('');
    const [productCost,setProductCost] = useState(0.00);
    const handleShow = () => {setShow(true)}
    const handleClose = () =>  {setShow(false)}
    const handleSubmit = async (event) => {
        event.preventDefault();
        console.log(productName, productCost, productType);
        const productPayload = {
            name: productName,
            cost: productCost,
            type: productName,
        }
        const productRequest = await createProductApi(productPayload);
        console.log(productRequest);
        handleClose();
        window.location.reload(false);

    }

    const createProductApi = (productPayload) => {
        return axios.post('http://localhost:8080/api/v1/products', productPayload);
    }
    return (
        <>
            <Button onClick={handleShow} >Create Product</Button>
            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    Create a new Client
                </Modal.Header>
                <Modal.Body>
                    <Form className={'mb-2'}>
                        <Form.Group>
                            <Form.Label htmlFor={'product-name'}>Product's Name</Form.Label>
                            <Form.Control type={'text'} id={'product-name'} value={productName} onChange={event => setProductName(event.target.value)}>

                            </Form.Control>
                            <Form.Label htmlFor={'product-type'}>Client's Last Name</Form.Label>
                            <Form.Select  type={'text'} id={'product-type'} value={productType} onChange={event => setProductType(event.target.value)}>
                                <option value={''}>Select One</option>
                                <option value={'Haircut'}>Haircut</option>
                                <option value={'HairProduct'}>Hair Product</option>
                            </Form.Select>
                            <Form.Label htmlFor={'product-cost'}>Client's Last Name</Form.Label>
                            <Form.Control  type={'number'} id={'product-cost'} value={productCost} onChange={event => setProductCost(event.target.value)}>

                            </Form.Control>
                        </Form.Group>
                        <Form.Group className={'mt-2'}>
                            <Button type={'submit'}  onClick={handleSubmit}> Create </Button>
                            <Button onClick={handleClose} variant={'danger'}>Close</Button>
                        </Form.Group>
                    </Form>
                </Modal.Body>
            </Modal>
        </>
    )
}