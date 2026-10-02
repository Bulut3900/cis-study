<template>
  <div class="about-page">
    <div class="page-header">
      <h1>{{ t('about.title') }}</h1>
    </div>

    <div class="container">
      <div class="section">
        <h2>{{ t('about.mission') }}</h2>
        <p class="intro-text">{{ t('about.intro') }}</p>
      </div>

      <div class="section">
        <h2>{{ t('about.contact') }}</h2>
        <div class="contact-list">
          <div class="contact-item">
            <span class="contact-icon">📧</span>
            <span class="contact-label">{{ t('about.email') }}</span>
            <span class="contact-value">contact@cisstudy.com</span>
          </div>
          <div class="contact-item">
            <span class="contact-icon">💬</span>
            <span class="contact-label">{{ t('about.whatsapp') }}</span>
            <span class="contact-value">+86 138 xxxx xxxx</span>
          </div>
          <div class="contact-item">
            <span class="contact-icon">📱</span>
            <span class="contact-label">{{ t('about.wechat') }}</span>
            <span class="contact-value">cis_study</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import { useI18n } from 'vue-i18n'
const { t } = useI18n()
</script>

<style scoped>
.about-page {
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
.section {
  background: #fff;
  border-radius: 12px;
  padding: 32px;
  box-shadow: 0 4px 12px rgba(0, 0, 0, 0.05);
  margin-bottom: 24px;
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
.contact-list {
  margin-top: 16px;
}
.contact-item {
  display: flex;
  align-items: center;
  padding: 16px 0;
  border-bottom: 1px solid #f0f0f0;
}
.contact-item:last-child {
  border-bottom: none;
}
.contact-icon {
  font-size: 24px;
  margin-right: 16px;
}
.contact-label {
  width: 100px;
  color: #666;
  font-size: 15px;
}
.contact-value {
  color: #333;
  font-size: 15px;
  font-weight: 500;
}
</style>