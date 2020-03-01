import React, {Component} from "react";
import {Container, Row, Badge} from 'reactstrap';

class Stocks extends Component {
    render() {
        return (
            <div>
                <Container fluid>
                    <Row>
                        <h1><Badge color="info">Stocks</Badge></h1>
                    </Row>
                    <Row>
                    </Row>
                </Container>
            </div>
        );
    }
}

export default Stocks;
