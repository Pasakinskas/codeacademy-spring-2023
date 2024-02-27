import './App.css';
import {MainComponent} from "./components/MainComponent";
import {HeaderComponent} from "./components/HeaderComponent";
import {FooterComponent} from "./components/FooterComponent";

function App() {
	return (
		<>
			<HeaderComponent />
			<MainComponent name={'Petras'} />
			<FooterComponent />
		</>
	);
}

export default App;
