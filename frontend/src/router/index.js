import { createRouter, createWebHistory } from 'vue-router'

const routes = [
  { path: '/', component: () => import('../views/Home.vue') },
  { path: '/schools', component: () => import('../views/Schools.vue') },
  { path: '/schools/:id', component: () => import('../views/SchoolDetail.vue') },
  { path: '/apply', component: () => import('../views/Apply.vue') },
  { path: '/apply/success', component: () => import('../views/ApplySuccess.vue') },
  { path: '/about', component: () => import('../views/About.vue') }
]

const router = createRouter({
  history: createWebHistory(),
  routes,
  scrollBehavior() {
    return { top: 0 }
  }
})

export default router