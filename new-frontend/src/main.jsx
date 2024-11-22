import './index.css'
import { StrictMode } from 'react'
import { createRoot } from 'react-dom/client'
import AppRouter from './routes/AppRouter.jsx'
import { BrowserRouter } from 'react-router-dom'
import { Provider } from 'react-redux'
import store from './reduxStore/index.jsx'

createRoot(document.getElementById('root')).render(
  <StrictMode>


    <Provider store={store}>

    <BrowserRouter>
      <AppRouter />
    </BrowserRouter>
    
    </Provider>


  </StrictMode>
)
