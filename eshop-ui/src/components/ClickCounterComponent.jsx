const ClickCounterComponent = (props) => {
	return <>
		<h2>You clicked {props.counter} times</h2>
		<button type="button" className="btn btn-primary" onClick={props.onClick}>Click me</button>
	</>;
}

export default ClickCounterComponent;
