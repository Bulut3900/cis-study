import request from '../utils/request'

// 学校列表
export const getSchoolList = () => request.get('/api/school/list')

// 学校详情
export const getSchoolDetail = (id) => request.get(`/api/school/${id}`)