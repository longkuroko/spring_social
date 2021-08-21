import React, { Component } from 'react'
import '../../assets/Style/CardMenu.scss'
import { ReactComponent as Notifications } from "../../assets/images/notifications.svg";
import { ReactComponent as Inbox } from "../../assets/images/inbox.svg";
import { ReactComponent as Comments } from "../../assets/images/comments.svg";
import { connect } from 'react-redux';


class CardMenu extends Component {

  

    render() {
        return (
            <div className="cardMenu">
                <div className="interactions">
                    <Notifications className="icon" onClick={() => {
                      
                    }} />
                    <Inbox className="icon" />
                    <Comments className="icon" />
                </div>
            </div>
        )
    }
}



export default connect()(CardMenu)