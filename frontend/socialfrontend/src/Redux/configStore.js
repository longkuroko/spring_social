import {combineReducers, createStore} from 'redux';
import { insReducer } from './Reducer/insReducer';


const rootReducers = combineReducers({
    //khai báo reducers tại đây:
    insReducer 

})

export const store = createStore(rootReducers)