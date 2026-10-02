<template>
  <el-config-provider :locale="elementLocale">
    <div class="app">
      <!-- 顶部导航 -->
      <header class="header">
        <div class="header-content">
          <div class="logo" @click="$router.push('/')">
            <span class="logo-icon">🎓</span>
            <span class="logo-text">CIS Study</span>
          </div>
          <nav class="nav">
            <router-link to="/">{{ t('nav.home') }}</router-link>
            <router-link to="/schools">{{ t('nav.schools') }}</router-link>
            <router-link to="/apply">{{ t('nav.apply') }}</router-link>
            <router-link to="/about">{{ t('nav.about') }}</router-link>
          </nav>
          <div class="lang-switch">
            <el-button link @click="switchLang('zh')" :type="locale === 'zh' ? 'primary' : ''">中文</el-button>
            <el-button link @click="switchLang('ru')" :type="locale === 'ru' ? 'primary' : ''">Русский</el-button>
          </div>
        </div>
      </header>

      <main class="main">
        <router-view />
      </main>

      <footer class="footer">
        <p>© 2026 CIS Study. All rights reserved.</p>
      </footer>
    </div>
  </el-config-provider>
</template>

<script setup>
import { computed } from 'vue'
import { useI18n } from 'vue-i18n'
import zhCn from 'element-plus/es/locale/lang/zh-cn'
import ruRu from 'element-plus/es/locale/lang/ru'

const { t, locale } = useI18n()

// Element Plus 语言包（跟随 i18n）
const elementLocale = computed(() => {
  return locale.value === 'ru' ? ruRu : zhCn
})

const switchLang = (lang) => {
  locale.value = lang
  localStorage.setItem('lang', lang)
}

// 从本地存储恢复语言
const savedLang = localStorage.getItem('lang')
if (savedLang) {
  locale.value = savedLang
}
</script>


<style>
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
body {
  font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'Microsoft YaHei', Arial, sans-serif;
  background: #f5f7fa;
  color: #333;
}
.app {
  min-height: 100vh;
  display: flex;
  flex-direction: column;
}
.header {
  background: #fff;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
  position: sticky;
  top: 0;
  z-index: 100;
}
.header-content {
  max-width: 1200px;
  margin: 0 auto;
  padding: 16px 24px;
  display: flex;
  align-items: center;
  justify-content: space-between;
}
.logo {
  display: flex;
  align-items: center;
  gap: 8px;
  font-size: 20px;
  font-weight: bold;
  cursor: pointer;
  color: #4a6cf7;
}
.logo-icon {
  font-size: 24px;
}
.nav {
  display: flex;
  gap: 32px;
}
.nav a {
  text-decoration: none;
  color: #666;
  font-size: 15px;
  transition: color 0.2s;
}
.nav a:hover,
.nav a.router-link-active {
  color: #4a6cf7;
  font-weight: 500;
}
.lang-switch {
  display: flex;
  gap: 8px;
}
.main {
  flex: 1;
}
.footer {
  text-align: center;
  padding: 24px;
  color: #999;
  font-size: 14px;
  background: #fff;
  border-top: 1px solid #eee;
}
</style>