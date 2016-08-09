/*******************************************************************************
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013,2014 by Peter Pilgrim, Addiscombe, Surrey, XeNoNiQUe UK
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU GPL v3.0
 * which accompanies this distribution, and is available at:
 * http://www.gnu.org/licenses/gpl-3.0.txt
 *
 * Developers:
 * Peter Pilgrim -- design, development and implementation
 *               -- Blog: http://www.xenonique.co.uk/blog/
 *               -- Twitter: @peter_pilgrim
 *
 * Contributors:
 *
 *******************************************************************************/

package je7hb.beanvalidation.payments;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

import static java.lang.annotation.ElementType.*;

/**
 * The type SecureReceipt
 *
 * @author Peter Pilgrim
 */
@Documented
@Constraint(validatedBy = SecureReceiptValidator.class)
@Target({ METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SecureReceipt {
    String message() default
        "{je7hb.beanvalidation.payment.SecureReceipt.message}" ;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
