import React, { Component } from "react";
import LoginInput from "./LoginInput";
import { NavLink } from "react-router-dom";
import { arrayform } from "../../interface";

interface IProp {
  class: string;
  form: arrayform;
}
interface inputstate {
  type: string;
  placeholder: string;
  id: string;
  name: string;
  label: string;
  send: boolean;
  value: string;
  error: string;
  required: boolean;
}
type inputstatearray = inputstate[];
interface IState {
  error: string;
  input: inputstatearray;
}
class AppForm extends Component<IProp, IState> {
  constructor(props: IProp) {
    super(props);

    this.state = {
      error: "",
      input: this.props.form.form.map((data) => {
        return {
          type: data.type,
          placeholder: data.placeholder,
          id: data.id,
          name: data.name,
          label: data.label,
          send: data.send,
          value: "",
          error: "",
          required: data.required,
        };
      }),
    };
    this.missingFormValues = this.missingFormValues.bind(this);
    this.updateValue = this.updateValue.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.resetlabel = this.resetlabel.bind(this);
    this.loginfetch = this.loginfetch.bind(this);
    this.handlingdata = this.handlingdata.bind(this);
    this.handlingerror = this.handlingerror.bind(this);
    this.handlingdatachecking =this.handlingdatachecking.bind(this);
  }
  handlingdatachecking(){
   return this.props.form.datachecking(this);
  }
  render() {
    //console.log(this.state);

    return (
      <div className={`${this.props.class} formDiv`}>
        <h1 className={`${this.props.class} loginHeader`}>
          {this.props.form.header}
        </h1>
        <div className={`${this.props.class} Loginform`}>
          <form
            className={`${this.props.class} form`}
            onSubmit={this.handleSubmit}
          >
            <div className={`${this.props.class} inputdiv`}>
              {construct(
                this.props,
                this.state.input,
                this.state,
                this.updateValue,
                this.resetlabel
              )}
            </div>
            <input
              className={`${this.props.class} submit`}
              type="submit"
              value="Submit"
            ></input>
            <br />
          </form>
          <NavLink
            className={`${this.props.class} regacc`}
            to="/forms/register"
          >
            Create an account
          </NavLink>
        </div>
      </div>
    );
  }
  updateValue(type: any, value: string) {
    this.setState((oldstate) => {
      var state = {} as IState;
      Object.assign(state, oldstate);
      for (var i = 0; i < state.input.length; i++) {
        if (state.input[i].id === type) {
          state.input[i].value = value;
          break;
        }
      }

      return state;
    });
  }

  handleSubmit(event: any) {
    var boolreqvalues = this.state.input.every((data) => {
      return data.required ? data.value.length > 0 : true;
    });
 
    if (boolreqvalues && this.handlingdatachecking()) {
      this.loginfetch();
    } else {
      console.log("fields empty");
      this.missingFormValues();
    }
    event.preventDefault();
  }
  missingFormValues() {
    const req = "Field Required";

    this.setState((state, props) => {
      var states: inputstatearray = state.input.map((data, index) => {
        var usererror = data.value === "" ? req : "";
        data.error = usererror;
        console.log(data);
        return data;
      });
      console.log(states);
      return { input: states };
    });
  }

  loginfetch() {
    let data = {};
    this.state.input.forEach((datas, index) => {
      Object.assign(data, { [datas.id]: datas.value });
    });

    fetch(this.props.form.url, {
      method: this.props.form.method,
      headers: {
        "Content-type": "application/json",
      },
      body: JSON.stringify(data),
    })
      .then((res) => {
        if (res.status === 200) {
          return res.json();
        } else {
          throw res;
        }
      })
      .then(this.handlingdata)
      .catch(this.handlingerror);
  }

  handlingerror(data: any) {
    this.props.form.error(data, this);
  }
  handlingdata(data: any) {
    this.props.form.datahandling(data, this);
  }
  resetlabel() {
    this.setState((state, props) => {
      var object = {} as IState;

      Object.assign(object, state);
      object.error = "";

      object.input.forEach((currentValue, index, array) => {
        currentValue.error = "";
      });
      return object;
    });
  }
}
export default AppForm;

function construct(
  props: IProp,
  input: inputstatearray,
  state: IState,
  updateValue: (type: any, value: string) => void,
  resetlabel: () => void
) {
  return input.map((data) => {
    return (
      <>
        <LoginInput
          key={data.name}
          value={data.value}
          fielderror={data.error}
          class={props.class}
          Data={data}
          error={state.error}
          onChange={updateValue}
          resetlabel={resetlabel}
        />
        <br />
      </>
    );
  });
}
