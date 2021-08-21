import React, { Component } from 'react'
import { Avatar } from '@material-ui/core'
import CardMenu from './CardMenu'
import "../../assets/Style/Card.scss"


export default class Card extends Component {

   


    render() {
        return (
            <div className="container">
                <div className="card">
                    <header>
                        <Avatar alt="Remy Sharp" src={this.props.user.img} className="profileIcon" />
                        <h3 className="ml-2">{this.props.user.name}</h3>
                    </header>
                    <img src="https://picsum.photos/200/200" className="cardImage" alt="carimg" />
                    <CardMenu />
                    <div className="likedBy">
                        <span>
                            835 like {this.props.user.name} <br /><strong>good</strong> and{" "}
                            <strong>Lợi others</strong>
                        </span>
                    </div>
                </div>
            </div>
        )
    }
}
