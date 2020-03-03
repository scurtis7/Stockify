import React, {Component} from "react";
import "./Home.css"
import {Container, Row, Col, Input, InputGroupText, InputGroup, InputGroupAddon, Button} from 'reactstrap';
import axios from "axios";

class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {
            results: [],
            keyword: '',
        };
        this.onChange = this.onChange.bind(this);
        this.search = this.search.bind(this);
        this.setResults = this.setResults.bind(this);
        this.loadSearchResults = this.loadSearchResults.bind(this);
    }

    onChange = (e) =>
        this.setState({ [e.target.name]: e.target.value });

    search() {
        this.setResults([]);
        axios.get('http://localhost:8080/alpha/search/' + this.state.keyword)
            .then(results => this.setResults(results.data))
            .catch(function (error) {
                console.log(error);
            });
    }

    setResults(results) {
        this.setState({results});
    }

    loadSearchResults() {
        if (this.state.results === null) {
            return (
                <Row className="Home-row">
                    Results
                </Row>
            );
        } else {
            return this.state.results.map((result, index) => {
                return (
                    <Row className="Home-row">
                        {result}
                    </Row>
                );
            });
        }
    }

    render() {
        return (
            <div className="Home">
                <Container fluid>
                    <Row>
                        <Col>
                            <InputGroup size="sm">
                                <InputGroupAddon addonType="prepend">
                                    <InputGroupText className="Home-input-group-text">Stock Search</InputGroupText>
                                </InputGroupAddon>
                                <Input placeholder="Keyword" value={this.state.keyword} name="keyword" onChange={this.onChange} type="string" />
                            </InputGroup>
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <Button className="Home-button" classActiveName="Home-button-active" onClick={this.search}>Search</Button>
                        </Col>
                    </Row>
                    <Row><br/></Row>
                    {this.loadSearchResults()}
                </Container>
            </div>
        );
    }
}

export default Home;
