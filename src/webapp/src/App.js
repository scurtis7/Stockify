import React, {Component} from 'react';
import Home from "./Home";
import Stocks from "./Stocks";
import Watchlist from "./Watchlist";
import About from "./About";
import SignIn from "./SignIn";
import {BrowserRouter, Route, NavLink, Link} from "react-router-dom";
import {Collapse, Nav, Navbar, NavbarBrand, NavbarToggler, NavItem} from "reactstrap";

class App extends Component {

    constructor(props) {
        super(props);
        this.state = {isOpen: false};
        this.toggle = this.toggle.bind(this);
    }

    toggle() {
        this.setState({
            isOpen: !this.state.isOpen
        });
    }

    render() {
        return (
            <BrowserRouter>
                <div>
                    <Navbar color="dark" dark expand="md">
                        <NavbarBrand tag={Link} exact="true" to="/">Stockify</NavbarBrand>
                        <NavbarToggler onClick={this.toggle}/>
                        <Collapse isOpen={this.state.isOpen} navbar>
                            <Nav className="mr-auto" navbar>
                                <NavItem><NavLink className="navlink" activeClassName="navlinkactive" to="/Stocks">Stocks</NavLink></NavItem>
                                <NavItem><NavLink className="navlink" activeClassName="navlinkactive" to="/Watchlist">Watchlist</NavLink></NavItem>
                            </Nav>
                            <Nav className="ml-auto" navbar>
                                <NavItem><NavLink className="navlink" activeClassName="navlinkactive" to="/about">About</NavLink></NavItem>
                                <NavItem><NavLink className="navlink" activeClassName="navlinkactive" to="/signin">Sign In</NavLink></NavItem>
                            </Nav>
                        </Collapse>
                    </Navbar>
                </div>
                <div className="content">
                    <Route exact path="/" component={Home}/>
                    <Route path="/Stocks" component={Stocks}/>
                    <Route path="/Watchlist" component={Watchlist}/>
                    <Route path="/about" component={About}/>
                    <Route path="/signin" component={SignIn}/>
                </div>
            </BrowserRouter>
        );
    }
}

export default App;
