<template>
  <div class="home">
    <!-- Hero 区 -->
    <section class="hero">
      <div class="hero-content">
        <h1 class="hero-title">{{ t('home.heroTitle') }}</h1>
        <p class="hero-subtitle">{{ t('home.heroSubtitle') }}</p>
        <el-button type="primary" size="large" @click="$router.push('/apply')">
          {{ t('home.heroButton') }}
        </el-button>
      </div>
    </section>

    <!-- 优势区 -->
    <section class="section">
      <h2 class="section-title">{{ t('home.advantageTitle') }}</h2>
      <div class="advantages">
        <div class="advantage-card" v-for="i in 4" :key="i">
          <div class="advantage-icon">{{ ['🎓', '💰', '🏆', '💼'][i - 1] }}</div>
          <h3>{{ t(`home.advantage${i}`) }}</h3>
          <p>{{ t(`home.advantage${i}Desc`) }}</p>
        </div>
      </div>
    </section>

    <!-- 学校展示区 -->
    <section class="section section-gray">
      <div class="section-header">
        <h2 class="section-title">{{ t('home.schoolsTitle') }}</h2>
        <el-button link @click="$router.push('/schools')">{{ t('home.viewAll') }} →</el-button>
      </div>
      <div class="schools-grid" v-loading="loading">
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
          </div>
        </div>
      </div>
    </section>
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
    schools.value = res.data.slice(0, 6)
  } finally {
    loading.value = false
  }
})
</script>

<style scoped>
.hero {
  background: linear-gradient(135deg, #4a6cf7 0%, #7b95ff 100%);
  color: #fff;
  padding: 80px 24px;
  text-align: center;
}
.hero-content {
  max-width: 800px;
  margin: 0 auto;
}
.hero-title {
  font-size: 48px;
  margin-bottom: 16px;
  font-weight: bold;
}
.hero-subtitle {
  font-size: 20px;
  margin-bottom: 32px;
  opacity: 0.95;
}
.section {
  max-width: 1200px;
  margin: 0 auto;
  padding: 60px 24px;
}
.section-gray {
  background: #f9fafb;
  max-width: 100%;
}
.section-header {
  max-width: 1200px;
  margin: 0 auto 32px;
  display: flex;
  justify-content: space-between;
  align-items: center;
}
.section-title {
  font-size: 32px;
  text-align: center;
  margin-bottom: 40px;
  color: #333;
}
.section-header .section-title {
  text-align: left;
  margin-bottom: 0;
}
.advantages {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(240px, 1fr));
  gap: 24px;
}
.advantage-card {
  background: #fff;
  padding: 32px 24px;
  border-radius: 12px;
  text-align: center;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
  transition: transform 0.2s;
}
.advantage-card:hover {
  transform: translateY(-4px);
}
.advantage-icon {
  font-size: 48px;
  margin-bottom: 16px;
}
.advantage-card h3 {
  font-size: 18px;
  margin-bottom: 8px;
  color: #333;
}
.advantage-card p {
  color: #666;
  font-size: 14px;
  line-height: 1.6;
}
.schools-grid {
  display: grid;
  grid-template-columns: repeat(auto-fit, minmax(300px, 1fr));
  gap: 24px;
  max-width: 1200px;
  margin: 0 auto;
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
  height: 180px;
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
  font-size: 64px;
}
.school-info {
  padding: 20px;
}
.school-info h3 {
  font-size: 18px;
  margin-bottom: 4px;
  color: #333;
}
.school-en {
  color: #999;
  font-size: 13px;
  margin-bottom: 8px;
}
.school-city {
  color: #666;
  font-size: 14px;
}
</style>