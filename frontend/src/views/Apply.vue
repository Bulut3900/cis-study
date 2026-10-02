<template>
  <div class="apply-page">
    <div class="page-header">
      <h1>{{ t('form.title') }}</h1>
    </div>

    <div class="container">
      <el-form
        ref="formRef"
        :model="form"
        :rules="rules"
        label-width="140px"
        label-position="top"
        class="apply-form"
      >
        <!-- 基本信息 -->
        <div class="form-section">
          <h3 class="form-section-title">{{ t('form.sectionBasic') }}</h3>

          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item :label="t('form.fullName')" prop="fullName">
                <el-input v-model="form.fullName" :placeholder="t('form.placeholderName')" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item :label="t('form.gender')" prop="gender">
                <el-radio-group v-model="form.gender">
                  <el-radio value="男">{{ t('form.male') }}</el-radio>
                  <el-radio value="女">{{ t('form.female') }}</el-radio>
                </el-radio-group>
              </el-form-item>
            </el-col>
          </el-row>

          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item :label="t('form.birthDate')" prop="birthDate">
                <el-date-picker
                  v-model="form.birthDate"
                  type="date"
                  value-format="YYYY-MM-DD"
                  style="width: 100%"
                />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item :label="t('form.nationality')" prop="nationality">
                <el-select v-model="form.nationality" :placeholder="t('form.placeholderNationality')" style="width: 100%">
                  <el-option label="哈萨克斯坦" value="哈萨克斯坦" />
                  <el-option label="乌兹别克斯坦" value="乌兹别克斯坦" />
                  <el-option label="吉尔吉斯斯坦" value="吉尔吉斯斯坦" />
                  <el-option label="塔吉克斯坦" value="塔吉克斯坦" />
                  <el-option label="土库曼斯坦" value="土库曼斯坦" />
                  <el-option label="其他" value="其他" />
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>

          <el-form-item :label="t('form.passportNo')" prop="passportNo">
            <el-input v-model="form.passportNo" />
          </el-form-item>
        </div>

        <!-- 联系方式 -->
        <div class="form-section">
          <h3 class="form-section-title">{{ t('form.sectionContact') }}</h3>

          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item :label="t('form.phone')" prop="phone">
                <el-input v-model="form.phone" :placeholder="t('form.placeholderPhone')" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item :label="t('form.email')" prop="email">
                <el-input v-model="form.email" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item :label="t('form.whatsapp')" prop="whatsapp">
                <el-input v-model="form.whatsapp" placeholder="+7 xxx xxx xxxx" />
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item :label="t('form.wechat')" prop="wechat">
                <el-input v-model="form.wechat" />
              </el-form-item>
            </el-col>
          </el-row>
        </div>

        <!-- 教育背景 -->
        <div class="form-section">
          <h3 class="form-section-title">{{ t('form.sectionEducation') }}</h3>

          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item :label="t('form.currentEducation')" prop="currentEducation">
                <el-select v-model="form.currentEducation" style="width: 100%">
                  <el-option label="高中" value="高中" />
                  <el-option label="本科" value="本科" />
                  <el-option label="硕士" value="硕士" />
                  <el-option label="其他" value="其他" />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item :label="t('form.currentSchool')" prop="currentSchool">
                <el-input v-model="form.currentSchool" />
              </el-form-item>
            </el-col>
          </el-row>
        </div>

        <!-- 留学意向 -->
        <div class="form-section">
          <h3 class="form-section-title">{{ t('form.sectionIntention') }}</h3>

          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item :label="t('form.targetSchool')" prop="targetSchoolId">
                <el-select v-model="form.targetSchoolId" style="width: 100%" clearable>
                  <el-option
                    v-for="s in schools"
                    :key="s.id"
                    :label="isRu ? s.nameRu : s.nameCn"
                    :value="s.id"
                  />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item :label="t('form.targetMajor')" prop="targetMajor">
                <el-input v-model="form.targetMajor" />
              </el-form-item>
            </el-col>
          </el-row>

          <el-row :gutter="20">
            <el-col :span="12">
              <el-form-item :label="t('form.targetDegree')" prop="targetDegree">
                <el-select v-model="form.targetDegree" style="width: 100%">
                  <el-option label="本科" value="本科" />
                  <el-option label="硕士" value="硕士" />
                  <el-option label="博士" value="博士" />
                </el-select>
              </el-form-item>
            </el-col>
            <el-col :span="12">
              <el-form-item :label="t('form.intakeYear')" prop="intakeYear">
                <el-select v-model="form.intakeYear" style="width: 100%">
                  <el-option label="2026" value="2026" />
                  <el-option label="2027" value="2027" />
                  <el-option label="2028" value="2028" />
                </el-select>
              </el-form-item>
            </el-col>
          </el-row>

          <el-form-item :label="t('form.message')" prop="message">
            <el-input v-model="form.message" type="textarea" :rows="4" />
          </el-form-item>
        </div>

        <!-- 提交按钮 -->
        <div class="form-actions">
          <el-button type="primary" size="large" :loading="submitting" @click="handleSubmit">
            {{ submitting ? t('form.submitting') : t('form.submit') }}
          </el-button>
        </div>
      </el-form>
    </div>
  </div>
</template>

<script setup>
import { ref, reactive, computed, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { useI18n } from 'vue-i18n'
import { ElMessage } from 'element-plus'
import { getSchoolList } from '../api/school'
import { submitApplication } from '../api/application'

const route = useRoute()
const router = useRouter()
const { t, locale } = useI18n()
const isRu = computed(() => locale.value === 'ru')

const formRef = ref(null)
const submitting = ref(false)
const schools = ref([])

const form = reactive({
  fullName: '',
  gender: '男',
  birthDate: '',
  nationality: '',
  passportNo: '',
  phone: '',
  email: '',
  wechat: '',
  whatsapp: '',
  currentEducation: '',
  currentSchool: '',
  targetSchoolId: null,
  targetMajor: '',
  targetDegree: '',
  intakeYear: '2026',
  message: ''
})

const rules = {
  fullName: [{ required: true, message: () => t('form.required'), trigger: 'blur' }],
  nationality: [{ required: true, message: () => t('form.required'), trigger: 'change' }],
  phone: [{ required: true, message: () => t('form.required'), trigger: 'blur' }],
  currentEducation: [{ required: true, message: () => t('form.required'), trigger: 'change' }]
}

onMounted(async () => {
  // 加载学校列表
  try {
    const res = await getSchoolList()
    schools.value = res.data
  } catch (e) {
    // 错误已处理
  }

  // 如果从学校详情页跳过来，自动选中学校
  if (route.query.schoolId) {
    form.targetSchoolId = Number(route.query.schoolId)
  }
})

const handleSubmit = async () => {
  await formRef.value.validate()

  submitting.value = true
  try {
    await submitApplication(form)
    router.push('/apply/success')
  } catch (e) {
    // 错误已处理
  } finally {
    submitting.value = false
  }
}
</script>

<style scoped>
.apply-page {
  min-height: calc(100vh - 200px);
}
.page-header {
  background: linear-gradient(135deg, #4a6cf7 0%, #7b95ff 100%);
  color: #fff;
  padding: 60px 24px;
  text-align: center;
}
.page-header h1 {
  font-size: 36px;
}
.container {
  max-width: 900px;
  margin: 0 auto;
  padding: 40px 24px;
}
.apply-form {
  background: #fff;
  border-radius: 12px;
  padding: 40px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
}
.form-section {
  margin-bottom: 32px;
  padding-bottom: 24px;
  border-bottom: 1px solid #eee;
}
.form-section:last-of-type {
  border-bottom: none;
}
.form-section-title {
  font-size: 18px;
  color: #4a6cf7;
  margin-bottom: 20px;
  padding-left: 12px;
  border-left: 3px solid #4a6cf7;
}
.form-actions {
  text-align: center;
  margin-top: 32px;
}
.form-actions .el-button {
  min-width: 200px;
}
</style>