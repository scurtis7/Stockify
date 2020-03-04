import React, {Component} from "react";
import "./Home.css"
import {Container, Row, Col, Input, InputGroupText, InputGroup, InputGroupAddon, Button, Table} from 'reactstrap';
import axios from "axios";

class Home extends Component {

    constructor(props) {
        super(props);
        this.state = {
            quotes: [],
            keyword: '',
            addSymbol: '',
            result: '',
        };
        this.onChange = this.onChange.bind(this);
        this.search = this.search.bind(this);
        this.add = this.add.bind(this);
        this.setResults = this.setResults.bind(this);
        this.loadSearchResults = this.loadSearchResults.bind(this);
    }

    onChange = (event) =>
        this.setState({ [event.target.name]: event.target.value });

    search() {
        this.setResults([]);
        axios.get('http://localhost:8080/alpha/search/' + this.state.keyword)
            .then(quotes => this.setResults(quotes.data))
            .catch(function (error) {
                console.log(error);
            });
    }

    add(symbol) {
        console.log("Add method called " + symbol);
        axios.post('http://localhost:8080/stockify/stock/' + symbol)
            .then(result => this.setResult(result.data))
            .catch(function (error) {
                console.log(error);
            });
    };

    setResults(quotes) {
        this.setState({quotes});
    }

    setResult(result) {
        this.setState({result});
    }

    loadSearchResults() {
        if (this.state.quotes === null) {
            return (
                <Row className="Home-row">
                    <tr><td colSpan="6">Loading...</td></tr>
                </Row>
            );
        } else {
            return this.state.quotes.map((quote, index) => {
                const {symbol, name, type, region, timezone, currency} = quote; //destructuring
                return (
                    <tr key={index}>
                        <td>{symbol}</td>
                        <td>{name}</td>
                        <td>{type}</td>
                        <td>{region}</td>
                        <td>{timezone}</td>
                        <td>{currency}</td>
                        <td><Button className="Home-button" classActiveName="Home-button-active" onClick={() => this.add(symbol)}>Add</Button></td>
                    </tr>
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
                    <Row><br/></Row>
                    <Row>
                        <Col>
                            <Button className="Home-button" classActiveName="Home-button-active" onClick={this.search}>Search</Button>
                        </Col>
                    </Row>
                    <Row><br/></Row>
                    <Row>
                        <Table className="Home-table">
                            <thead>
                                <tr>
                                    <th>Symbol</th>
                                    <th>Name</th>
                                    <th>Type</th>
                                    <th>Region</th>
                                    <th>Timezone</th>
                                    <th>Currency</th>
                                    <th>Action</th>
                                </tr>
                            </thead>
                            <tbody>
                                {this.loadSearchResults()}
                            </tbody>
                        </Table>
                    </Row>
                </Container>
            </div>
        );
    }
}

export default Home;
