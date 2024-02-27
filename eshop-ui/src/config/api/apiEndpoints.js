import HTTP from "./axiosConfig";

const getProductsApi = () => HTTP.get('/products')
const getCurrenciesApi = () => HTTP.get('/currencies')

export {
	getProductsApi,
	getCurrenciesApi
}
