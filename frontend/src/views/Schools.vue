<template>
  <div class="schools-page">
    <div class="page-header">
      <h1>{{ t('school.listTitle') }}</h1>
    </div>

    <div class="container" v-loading="loading">
      <div class="schools-grid">
        <div
          class="school-card"
          v-for="school in schools"
          :key="school.id"
          @click="$router.push(`/schools/${school.id}`)"
        >
          <div class="school-cover">
            <img v-if="school.coverUrl" :src="school.coverUrl" :alt="school.nameCn" />
            <div v-else class="school-cover-placeholder">🏛️</div>
          </div>
          <div class="school-info">
            <h3>{{ isRu ? school.nameRu : school.nameCn }}</h3>
            <p class="school-en">{{ school.nameEn }}</p>
            <p class="school-city">📍 {{ school.city }}</p>
            <p class="school-intro">{{ isRu ? school.introRu : school.introCn }}</p>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { ref, computed, onMounted } from 'vue'
import { useI18n } from 'vue-i18n'
import { getSchoolList } from '../api/school'

const { t, locale } = useI18n()
const isRu = computed(() => locale.value === 'ru')

const schools = ref([])
const loading = ref(false)

onMounted(async () => {
  loading.value = true
  try {
    const res = await getSchoolList()
    schools.value = res.data
  } finally {
    loading.value = false
  }
})
</script>

<style scoped>
.schools-page {
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
  max-width: 1200px;
  margin: 0 auto;
  padding: 40px 24px;
}
.schools-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(320px, 1fr));
  gap: 24px;
}
.school-card {
  background: #fff;
  border-radius: 12px;
  overflow: hidden;
  cursor: pointer;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
  transition: all 0.2s;
}
.school-card:hover {
  transform: translateY(-4px);
  box-shadow: 0 8px 20px rgba(0, 0, 0, 0.1);
}
.school-cover {
  height: 200px;
  background: #e8edff;
  display: flex;
  align-items: center;
  justify-content: center;
  overflow: hidden;
}
.school-cover img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
.school-cover-placeholder {
  font-size: 72px;
}
.school-info {
  padding: 24px;
}
.school-info h3 {
  font-size: 20px;
  margin-bottom: 6px;
  color: #333;
}
.school-en {
  color: #999;
  font-size: 14px;
  margin-bottom: 12px;
}
.school-city {
  color: #666;
  font-size: 14px;
  margin-bottom: 12px;
}
.school-intro {
  color: #666;
  font-size: 14px;
  line-height: 1.6;
  display: -webkit-box;
  -webkit-line-clamp: 2;
  -webkit-box-orient: vertical;
  overflow: hidden;
}
</style>