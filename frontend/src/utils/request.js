import axios from 'axios'
import { ElMessage } from 'element-plus'

const request = axios.create({
    baseURL: '',   // 空字符串，请求 /api/xxx 会被 Nginx 转发到后端
    timeout: 15000
})

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