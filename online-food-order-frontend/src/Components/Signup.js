import { Button, Card, CardBody, CardHeader, Col, Container, Form, FormGroup, Input, Label, Row } from "reactstrap";
import Base from "./Base";
import { signup } from "../Service/UserService";
import { toast } from 'react-toastify'
import { useState } from "react";


function Signup() {

    const [data, setData] = useState({
        name: '',
        email: '',
        number: '',
        password: ''

    })
    const [error, setError] = useState({
        errors: {},
        isError: false,
    })
    const handleChange = (e, property) => {
        setData({ ...data, [property]: e.target.value })
    }
    const submitForm = (event) => {
        event.preventDefault();
        signup(data).then((resp) => {
            console.log("Succes log");
            console.log(resp);
            toast.success("User Registred Successfully")
            setData({
                name: '',
                email: '',
                number: '',
                password: '',
            })

        }).catch((error) => {
            console.log(error);
            toast.error("Error While Registaration")
            setError({
                errors: error,
                isError: true,
            })
        })
    }

    return (

        <Base>
            <Container>
                <Row className="mt-4">
                    <Col sm={{ size: 6, offset: 3 }}>
                        <Card className="white">
                            <CardHeader className="text-center loginPage">
                                <h3>Fill the Information to Register</h3>
                            </CardHeader>
                            <CardBody className="loginPage">
                                {/* creating Form */}
                                <Form onSubmit={submitForm}>
                                    {/* Name Field */}
                                    <FormGroup>
                                        <Label for="name">Name</Label>
                                        <Input type="text"
                                            id="name"
                                            placeholder="Enter here"
                                            onChange={(e) => handleChange(e, "name")}
                                            value={data.name}
                                        />
                                    </FormGroup>
                                    {/* Email Field */}
                                    <FormGroup>
                                        <Label for="email">Email</Label>
                                        <Input type="email"
                                            id="email"
                                            placeholder="Enter here"
                                            onChange={(e) => handleChange(e, "email")}
                                            value={data.email}
                                        />
                                    </FormGroup>
                                    {/* Password Field */}
                                    <FormGroup>
                                        <Label for="password">Password</Label>
                                        <Input type="password"
                                            id="password"
                                            placeholder="Enter here"
                                            onChange={(e) => handleChange(e, "password")}
                                            value={data.password}
                                        />
                                    </FormGroup>
                                    {/* About Field */}
                                    <FormGroup>
                                        <Label for="number">Phone Number</Label>
                                        <Input type="text"
                                            id="number"
                                            placeholder="Enter here"
                                            onChange={(e) => handleChange(e, "number")}
                                            value={data.number}
                                        />
                                    </FormGroup>
                                    <Container className="text-center">
                                        <Button color="success">Submit</Button>
                                    </Container>
                                </Form>
                            </CardBody>
                        </Card>
                    </Col>
                </Row>
            </Container>


        </Base>
    )
}
export default Signup;