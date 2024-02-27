import {useState} from "react";
import ClickCounterComponent from "./ClickCounterComponent";
import CurrenciesPage from "../pages/CurrenciesPage";
import ProductsPage from "../pages/ProductsPage";

export const MainComponent = ({
  name,
  salary = 1000
}) => {
	// react hooks
	const [counter, setCounter] = useState(0)

	const btnClickHandler = () => {
		setCounter(counter + 1)
	}

	return <main>
{/*		Hello, {name}!
		<p>
			<span>Salaray: {salary}</span>
		</p>
		<ClickCounterComponent counter={counter} onClick={btnClickHandler}/>*/}

		{/*<CurrenciesPage />*/}
		<ProductsPage />
	</main>
}
