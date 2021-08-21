import React, { Component } from 'react'
import Card from '../../components/HomePage/Card'
import Navigation from '../../components/HomePage/Navigation'
import "../../assets/Style/Home.scss"
import dataUser from '../../assets/Data/user'



export default class Home extends Component {


    renderCard = () => {
        return dataUser.map((user, index) => {
            return <frames key={{ index }}>
                <Card user={user} />
            </frames>
        })
    }
    render() {
        return (
            <div className="container">
                <div>
                    <Navigation />
                </div>
                <div className="row">
                    <div className="col-7">
                        {this.renderCard()}
                    </div>
                </div>
            </div>
        )
    }
}
