Basic Spring Rest Demo
This project involves creating a Spring rest controller.
Annotations used 
@RestController
@RequestMapping
@GetMapping
@PathVariable
@Configuration
@ComponentScan

This project also include all java configuration of Spring.
We make use of AbstractAnnotationConfigDispatcherServletInitializer and override its methods -
SpringMvcDispatchServletInitializer extends AbstractAnnotationConfigDispatcherServletInitializer
	@Override
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] {DemoAppConfig.class};
	}
	
	@Override
	protected String[] getServletMappings() {
		
		return new String[] {"/"};
	}
	
This project also contains information on how we handle exception in Spring Rest
1.Create an error response class -StudentErrorResponse
2.Create a custom exception class-StudentNotFoundException that extends RuntimeException and override all methods
3.Define and add @ExceptionHandler method that will return ResponseEntity and HTTP Status code in a global ExceptionHandlerController
with @ControllerAdvice.

API Design Best Practices:
PayPal uses:
GET https://api-m.sandbox.paypal.com/v1/invoicing/invoices/{invoice_id}
GET https://api-m.sandbox.paypal.com/v2/invoicing/invoices
POST https://api-m.sandbox.paypal.com/v2/invoicing/invoices
DELETE https://api-m.sandbox.paypal.com/v2/invoicing/invoices/{invoice_id}
PUT https://api-m.sandbox.paypal.com/v2/invoicing/invoices/{invoice_id}
		
		