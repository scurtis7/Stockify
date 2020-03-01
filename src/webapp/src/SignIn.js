import React, {Component} from "react";
import {Container, Row, Badge} from 'reactstrap';

class SignIn extends Component {
    render() {
        return (
            <div>
                <Container fluid>
                    <Row>
                        <h1><Badge color="info">SignIn</Badge></h1>
                    </Row>
                    <Row>
                    </Row>
                </Container>
            </div>
        );
    }
}

export default SignIn;
