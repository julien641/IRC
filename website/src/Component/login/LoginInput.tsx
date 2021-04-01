import React, { Component } from "react";
import { Forms } from "../../interface";
interface IProps {
  Data: Forms;
  onChange(type: string, value: string): void;
  resetlabel(): void;
  error: string;
  class: string;
  value: string;
  fielderror: string;
}
interface IState {
  Data: Forms;
  style: any;
  error: string;
  label: string;
}
class LoginInput extends Component<IProps, IState> {
  constructor(props: IProps) {
    super(props);
    this.state = {
      Data: props.Data,
      style: {},
      error: this.props.error,
      label: "",
    };
    this.handlechange = this.handlechange.bind(this);
    this.handleSelect = this.handleSelect.bind(this);
  }

  handlechange(event: any) {
    this.props.onChange(this.props.Data.name, event.target.value);
    /* @ts-ignore */
    this.setState((state) => {
      /* @ts-ignore */
      let object: Forms = {};
      Object.assign(object, state.Data);

      return object;
    });
    this.props.resetlabel();
  }
  handleSelect(event: any, bool: boolean) {
    this.props.resetlabel();
    if (bool) {
      this.setState((state, props) => {
        /* @ts-ignore */
        let data: Forms = {};
        Object.assign(data, state.Data);

        return {
          label: data.label,
          Data: data,
          style: {
            resize: "both",
            outline: "none !important",
            border: "2px solid #2abbcf",
          },
          error: "",
        };
      });
    } else if (event.target.value.length === 0) {
      this.setState(() => {
        return { label: "", style: {}, error: "" };
      });
    }
  }

  componentDidUpdate(prevProps: IProps, prevState: IState, snapshot: any) {
    if (prevProps !== this.props) {
      if (this.props.fielderror !== "") {
        this.setState({ error: "", label: "" });
      } else if (this.props.error !== "") {
        this.setState({
          error: "",
          label: "",
        });
      } else {
        this.setState({ error: this.props.error });
      }
    }
  }

  render() {
    return (
      <>
        <label
          className={`${this.props.class} loginlabel`}
          htmlFor={this.props.Data.id}
        >
          {this.state.label}
          {this.props.fielderror}
          {this.props.error}
        </label>
        <br />
        <input
          className={`${this.props.class} inputLogin`}
          style={this.state.style}
          type={this.props.Data.type}
          placeholder={this.props.Data.placeholder}
          name={this.props.Data.name}
          value={this.props.value}
          id={this.props.Data.id}
          onChange={this.handlechange}
          onBlur={(event) => {
            this.handleSelect(event, false);
          }}
          //onBlur={this.handleDeselect}
          onSelect={(event) => {
            this.handleSelect(event, true);
          }}

          //   onSelect={this.handlePasswordselect}
          //  onChange={this.handlePasswordChange}
        ></input>
      </>
    );
  }
}
export default LoginInput;
