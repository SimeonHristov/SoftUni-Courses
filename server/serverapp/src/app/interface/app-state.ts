import { DefaultTitleStrategy } from "@angular/router";
import { DataState } from "../enum/data-state.enum";

export interface AppState <T> { //appstate at any given moment
    dataState: DataState;
    appData?: T;    //optional, won't have both at the same time
    error?: string; //optional, won't have both at the same time
}