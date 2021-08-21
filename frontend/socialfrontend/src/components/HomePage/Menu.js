import React, { Component } from 'react'
import { ReactComponent as Home } from "../../assets/images/home.svg"
import { ReactComponent as Inbox } from "../../assets/images/inbox.svg"
import { ReactComponent as Explore } from "../../assets/images/explore.svg"
import { ReactComponent as Notifications } from "../../assets/images/notifications.svg"
import "../../assets/Style/Menu.scss"

export default class Menu extends Component {
    render() {
        return (
            <div className="menu">
                <Home className="icon" />
                <Inbox className="icon" />
                <Explore className="icon" />
                <Notifications className="icon" />
            </div>
        )
    }
}
