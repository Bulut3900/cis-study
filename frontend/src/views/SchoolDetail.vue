<template>
  <div class="detail-page" v-loading="loading">
    <div v-if="school" class="container">
      <!-- 学校头部 -->
      <div class="school-header">
        <div class="school-cover">
          <img v-if="school.coverUrl" :src="school.coverUrl" :alt="school.nameCn" />
          <div v-else class="school-cover-placeholder">🏛️</div>
        </div>
        <div class="school-header-info">
          <h1>{{ isRu ? school.nameRu : school.nameCn }}</h1>
          <p class="school-en">{{ school.nameEn }}</p>
          <p class="school-city">📍 {{ t('school.city') }}：{{ school.city }}</p>
          <el-button type="primary" size="large" @click="goApply">
            {{ t('school.applyNow') }}
          </el-button>
        </div>
      </div>

      <!-- 学校介绍 -->
      <div class="section">
        <h2>{{ t('school.intro') }}</h2>
        <p class="intro-text">{{ isRu ? school.introRu : school.introCn }}</p>
      </div>
    </div>

    <div v-else-if="!loading" class="not-found">
      <el-empty description="学校不存在" />
      <el-button @click="$router.push('/schools')">返回学校列表</el-button>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'
import { useRoute, useRouter } from 'vue-router'
import { useI18n } from 'vue-i18n'
import { getSchoolDetail } from '../api/school'

const route = useRoute()
const router = useRouter()
const { t, locale } = useI18n()
const isRu = computed(() => locale.value === 'ru')

const school = ref(null)
const loading = ref(false)

onMounted(async () => {
  loading.value = true
  try {
    const res = await getSchoolDetail(route.params.id)
    school.value = res.data
  } catch (e) {
    // 错误已由拦截器处理
  } finally {
    loading.value = false
  }
})

const goApply = () => {
  router.push({ path: '/apply', query: { schoolId: school.value.id } })
}
</script>

<style scoped>
.detail-page {
  min-height: calc(100vh - 200px);
}
.container {
  max-width: 1000px;
  margin: 0 auto;
  padding: 40px 24px;
}
.school-header {
  display: flex;
  gap: 40px;
  background: #fff;
  border-radius: 12px;
  padding: 32px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
  margin-bottom: 32px;
}
.school-cover {
  width: 280px;
  height: 200px;
  border-radius: 8px;
  background: #e8edff;
  display: flex;
  align-items: center;
  justify-content: center;
  overflow: hidden;
  flex-shrink: 0;
}
.school-cover img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
.school-cover-placeholder {
  font-size: 80px;
}
.school-header-info {
  flex: 1;
  display: flex;
  flex-direction: column;
  justify-content: center;
}
.school-header-info h1 {
  font-size: 32px;
  margin-bottom: 8px;
  color: #333;
}
.school-en {
  color: #999;
  font-size: 16px;
  margin-bottom: 12px;
}
.school-city {
  color: #666;
  font-size: 15px;
  margin-bottom: 20px;
}
.section {
  background: #fff;
  border-radius: 12px;
  padding: 32px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
}
.section h2 {
  font-size: 22px;
  margin-bottom: 16px;
  color: #333;
  padding-bottom: 12px;
  border-bottom: 2px solid #4a6cf7;
  display: inline-block;
}
.intro-text {
  color: #555;
  font-size: 15px;
  line-height: 1.8;
  margin-top: 16px;
}
.not-found {
  text-align: center;
  padding: 80px 24px;
}
</style>