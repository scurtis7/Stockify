import React, {Component} from "react";
import "./Home.css"
import {Container, Row, Badge} from 'reactstrap';

class Home extends Component {
    render() {
        return (
            <div>
                <Container fluid>
                    <Row>
                        <h1><Badge color="info">Home</Badge></h1>
                    </Row>
                    <Row>
                    </Row>
                </Container>
            </div>
        );
    }
}

export default Home;
