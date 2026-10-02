import request from '../utils/request'

// 提交报名
export const submitApplication = (data) => request.post('/api/application/submit', data)