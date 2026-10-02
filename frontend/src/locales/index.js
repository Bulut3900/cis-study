import { createI18n } from 'vue-i18n'
import zh from './zh'
import ru from './ru'

const i18n = createI18n({
  legacy: false,
  locale: 'zh',           // 默认中文
  fallbackLocale: 'zh',
  messages: { zh, ru }
})

export default i18n