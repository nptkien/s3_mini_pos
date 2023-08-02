import { ApiConfig } from "./api_config"
import Endpoint from "./end_point";
export const apiLogin = async (payload: { account: string, password: string }) => {
    return ApiConfig(Endpoint.LOGIN, { "email": payload.account, "password": payload.password })
}

export const apiRegister = async (payload: { account: string, password: string }) => {
    return ApiConfig(Endpoint.LOGIN, payload)
}

