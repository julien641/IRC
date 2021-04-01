
import AppForm from './Component/login/AppForm'
export interface Forms {
  type: string;
  placeholder: string;
  id: string;
  name: string;
  label: string;
  send: boolean;
  required: boolean;
}

export type arrayform = {
  form: Forms[];
  header:string;
  class:string;
  url: string;
  method: string;
  datachecking(appform:AppForm): boolean;
  datahandling(data: any,appform:AppForm): any;
  error(error: any,appForm:AppForm): any;
};
