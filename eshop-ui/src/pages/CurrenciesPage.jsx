import {useEffect, useState} from "react";
import {getCurrenciesApi} from "../config/api/apiEndpoints";

const initialRatesState = {
	rates: {
		currency: '',
		rate: 0
	},
	base: '',
	date: ''
}

const CurrenciesPage = () => {

	const [ratesData, setRatesData] = useState(initialRatesState);

	useEffect(() => {
		getCurrenciesApi()
			.then(response => {
				console.log(response);
				setRatesData(response.data);
			})
			.catch(error => {
				console.log(error);
			});
	}, [])

	return (
		<div>
			<h2>Exchange Rates for {ratesData.date}</h2>
			<p>Base Currency: {ratesData.base}</p>
			<table>
				<thead>
				<tr>
					<th>Currency</th>
					<th>Exchange Rate</th>
				</tr>
				</thead>
				<tbody>
				{Object.entries(ratesData.rates).map(([currency, rate]) => (
					<tr key={currency}>
						<td>{currency}</td>
						<td>{rate}</td>
					</tr>
				))}
				</tbody>
			</table>
		</div>
	);
}

export default CurrenciesPage;
