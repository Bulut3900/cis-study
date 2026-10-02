<template>
  <div class="success-page">
    <div class="success-card">
      <div class="success-icon">✅</div>
      <h1>{{ t('form.success') }}</h1>
      <p class="success-tip">我们会在 1-2 个工作日内联系你</p>
      <div class="success-actions">
        <el-button type="primary" @click="$router.push('/')">返回首页</el-button>
        <el-button @click="$router.push('/schools')">查看学校</el-button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useI18n } from 'vue-i18n'
const { t } = useI18n()
</script>

<style scoped>
.success-page {
  min-height: calc(100vh - 200px);
  display: flex;
  align-items: center;
  justify-content: center;
  padding: 40px 24px;
}
.success-card {
  background: #fff;
  border-radius: 16px;
  padding: 60px 40px;
  text-align: center;
  max-width: 500px;
  width: 100%;
  box-shadow: 0 8px 24px rgba(0, 0, 0, 0.08);
}
.success-icon {
  font-size: 80px;
  margin-bottom: 24px;
}
.success-card h1 {
  font-size: 24px;
  color: #333;
  margin-bottom: 12px;
}
.success-tip {
  color: #999;
  font-size: 15px;
  margin-bottom: 32px;
}
.success-actions {
  display: flex;
  gap: 12px;
  justify-content: center;
}
</style>