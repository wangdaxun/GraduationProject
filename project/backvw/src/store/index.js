import {createStore,applyMiddleware, compose} from "redux";
import reducer from './reducer';
import promiseMiddleware from 'redux-promise-middleware';
// 设置调试工具
const composeEnhancers = window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__ ? window.__REDUX_DEVTOOLS_EXTENSION_COMPOSE__({}) : compose;
// 设置中间件
const enhancer = composeEnhancers(
    applyMiddleware(promiseMiddleware)
);
const store = createStore(
    reducer,
    enhancer
);
export default store;
