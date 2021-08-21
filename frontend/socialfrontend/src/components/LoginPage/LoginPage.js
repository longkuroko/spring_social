import React, { Component } from 'react'
import { NavLink } from 'react-router-dom'


export default class LoginPage extends Component {
    render() {
        return (
            <div className="container">
                <div className="row">
                    <div className="col-6">
                        <img src="https://picsum.photos/200/200" className="w-100" />
                    </div>
                    <div className="col-6">
                        <h3>LOGIN</h3>
                        <div className="form-group">
                            <span>Tài Khoản</span>
                            <input className="form-control" name="taiKhoan" />
                        </div>
                        <div className="form-group">
                            <span>Mật Khẩu</span>
                            <input className="form-control" name="matKhau" />
                        </div>
                        <div>
                            <NavLink className="btn btn-outline-danger" to="/home">ĐĂNG NHẬP</NavLink>
                        </div>
                    </div>
                </div>
            </div>
        )
    }
}
