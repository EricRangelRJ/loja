import { HTTP_INTERCEPTORS, HttpClientModule } from '@angular/common/http';
import ptBr from '@angular/common/locales/pt';
import { DEFAULT_CURRENCY_CODE, LOCALE_ID, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { AppRoutingModule } from './app-routing.module';
import { ClientesModule } from './clientes/clientes.module';
import { FornecedoresModule } from './fornecedores/fornecedores.module';
import { HomeModule } from './home/home.module';
import { PedidosModule } from './pedidos/pedidos.module';
import { ProdutosModule } from './produtos/produtos.module';
import { RelatoriosModule } from './relatorios/relatorios.module';
import { UsuariosModule } from './usuarios/usuarios.module';
import { VendedoresModule } from './vendedores/vendedores.module';

import { registerLocaleData } from '@angular/common';
import { MAT_DATE_LOCALE } from '@angular/material/core';
import { MatPaginatorIntl } from '@angular/material/paginator';
import { httpInterceptorProviders } from './_interceptors/index';
import { AppComponent } from './app.component';
import { TraducaoMatPaginatorIntl } from './shared/traducao-mat-paginator-intl';
import { MatProgressSpinnerModule } from '@angular/material/progress-spinner';
import { LoadingComponent } from "./loading/loading.component";
import { LoadingInterceptor } from './_interceptors/loading.interceptor';

registerLocaleData(ptBr);
@NgModule({
  declarations: [
    AppComponent
  ],
  providers: [
    { provide: MatPaginatorIntl, useClass: TraducaoMatPaginatorIntl },
    { provide: MAT_DATE_LOCALE, useValue: 'pt-BR' },
    { provide: LOCALE_ID, useValue: 'pt' },
    { provide: DEFAULT_CURRENCY_CODE, useValue: 'BRL' },
    { provide: HTTP_INTERCEPTORS, useClass: LoadingInterceptor, multi: true },
    httpInterceptorProviders
  ],
  bootstrap: [AppComponent],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    HomeModule,
    VendedoresModule,
    ClientesModule,
    FornecedoresModule,
    ProdutosModule,
    PedidosModule,
    UsuariosModule,
    RelatoriosModule,
    MatProgressSpinnerModule,
    LoadingComponent
  ]
})
export class AppModule {
}
