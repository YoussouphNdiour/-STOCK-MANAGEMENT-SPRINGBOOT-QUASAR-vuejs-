const routes = [
  {
    path: '/',
    component: () => import('layouts/MainLayout.vue'),
    children: [
      { path: '', component: () => import('pages/Index.vue') },
      { path: '/order', component: () => import('pages/order.vue') },
      { path: '/product', component: () => import('pages/Product.vue') },
      { path: '/sale', component: () => import('pages/Sale.vue') },
      { path: '/provider', component: () => import('pages/provider.vue') },
      { path: '/user', component: () => import('pages/User.vue') }


    ]
  },

  // Always leave this as last one,
  // but you can also remove it
  {
    path: '/:catchAll(.*)*',
    component: () => import('pages/Error404.vue')
  }
]

export default routes
