import axios from 'axios'
import { ElMessage } from 'element-plus'

const request = axios.create({
    baseURL: 'http://localhost:8080',   // 后端地址
    timeout: 15000
})

// 响应拦截器
request.interceptors.response.use(
    response => {
        const res = response.data
        if (res.code === 200) {
            return res
        }
        ElMessage.error(res.message || '请求失败')
        return Promise.reject(new Error(res.message || '请求失败'))
    },
    error => {
        ElMessage.error('网络异常，请稍后重试')
        return Promise.reject(error)
    }
)

export default request