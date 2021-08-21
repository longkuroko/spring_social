import React, { Component } from 'react'
import "../../assets/Style/Navigation.scss"
import logo from '../../assets/images/instagramLogo.png'
import searchIcon from '../../assets/images/searchIcon.png'
import { NavLink } from 'react-router-dom'
import Menu from './Menu'

export default class Navigation extends Component {
    render() {
        return (
            <div className="navigation">
                <div className="container">
                    <NavLink exact to="/home">
                        <img className="logo" src={logo} alt="logo" />
                    </NavLink>
                    <div className="search">
                        <img className="searchIcon" src={searchIcon} alt="searchIcon" />
                        <span className="searchText">Search</span>
                    </div>
                </div>
                <Menu />

            </div>
        )
    }
}
