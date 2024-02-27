import {getProductsApi} from "../config/api/apiEndpoints";
import {useEffect, useState} from "react";

const initialProductsState =
	[
		{
			amount: 0,
			name: '',
			price: 0,
			productId: ''
		}
	]

const ProductsPage = () => {

	const [products, setProducts] = useState(initialProductsState);

	useEffect(() => {
		// Fetch products data
		getProductsApi()
			.then(response => {
				console.log(response);
				setProducts(response.data);
			})
			.catch(error => {
				console.log(error);
			});
	}, [])

	return (
		<div>
			<h1>Products</h1>

			<div className="d-flex justify-content-around flex-wrap">
				{products.map((product, key) => (
					<div className="card" style={{width: "18rem"}} key={product.productId}>
						<img src="#" className="card-img-top" alt="..."/>
						<div className="card-body">
							<h5 className="card-title">{product.name}</h5>
							<p className="card-text">{product.price}</p>
							<a href="#" className="btn btn-primary">Add to cart</a>
						</div>
					</div>
				))
				}
			</div>
		< /div>
	)
}

export default ProductsPage;
